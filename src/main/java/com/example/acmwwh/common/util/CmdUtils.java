package com.example.acmwwh.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 外部命令工具类
 * 
 * @author linfan
 * @since 2024/05/10
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class CmdUtils {

    public static boolean exec(String cmd) {

        ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", cmd);

        Process process = null;
        BufferedReader reader = null;
        try {
            process = processBuilder.redirectErrorStream(true).start();

            int exitCode = process.waitFor();
            if (0 == exitCode) {
                return true;
            } else {
                reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                StringBuilder output = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line);
                }
                log.error("Failure to execute '{}', because {}", cmd, output);
            }
        } catch (Exception e) {
            log.error("Failure to execute '{}', because {}", cmd, e.getMessage(), e);
        } finally {
            try {
                if (null != reader) {
                    reader.close();
                }

                if (null != process) {
                    // 强制终止子进程（如果还在运行）
                    if (process.isAlive()) {
                        process.destroyForcibly();
                    }
                    // 关闭子进程的标准输入和错误流
                    if (!process.isAlive()) {
                        process.getInputStream().close();
                        process.getErrorStream().close();
                    }
                }
            } catch (IOException ioException) {
                // 记录异常信息，但不中断主要逻辑
                log.error("Error occurred while closing resources for command '{}': {}", cmd, ioException.getMessage());
            }
        }
        return false;
    }
}
