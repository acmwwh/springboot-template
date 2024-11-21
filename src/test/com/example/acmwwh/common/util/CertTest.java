package com.example.acmwwh.common.util;

import java.io.IOException;
import java.security.cert.CertificateException;

/**
 * @author linfan
 * @since 2024/11/21
 */
public class CertTest {

    public static void main(String[] args) throws CertificateException, IOException {
        String cert =
            "-----BEGIN CERTIFICATE-----\n" + "MIIC4zCCAcugAwIBAgIhAJHFtBSRpax3l8QX8mbBYsAqNP9aYmQhH8X3/8yVdmmb\n"
                + "MA0GCSqGSIb3DQEBCwUAMBsxDDAKBgNVBAMMA1JTQTELMAkGA1UEBhMCQ04wIBcN\n"
                + "MjQxMTExMTYwMDAwWhgPMjA1MjEyMzExNTU5NTlaMBsxDDAKBgNVBAMMA1JTQTEL\n"
                + "MAkGA1UEBhMCQ04wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCro/KP\n"
                + "zoKYKKMGGbsbWvYQLX+WNWzKr6tIDvys/tesIeEraxhcDy0MydESP/Sj/p8rBjgf\n"
                + "Xwvj1kIhMeW3w3P6XF5tv9hMfs7XZB99qj+oFOOwwfylMZsipSoa26emMD+qJM73\n"
                + "e/8pdp8udJHTQxbUbz2xeDqjC6apIqENhuzDKZzjre0ub/ZTAZrnB9xwtowoUq6J\n"
                + "Pbza5/hzkv3St5m0VdvXifJ5wKcR564QWth0a/vErh5Cum3z9Z9aEQ0r+gxKpH/7\n"
                + "8xyul6DPS3NDQ/fWJeMIUVmzB3XbcBM1MUfnVtwz8VPW02LGBOtATDIb6zF6x3ov\n"
                + "Ic29w1CJj7Z4r927AgMBAAGjEDAOMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEL\n"
                + "BQADggEBAGa8rltFwfixScmJBjljlAgtYxOfXW/tbI1qxC6ObjSsR/6Dh+wQbG49\n"
                + "pEidpTpdgVO4bKy4kGs+rkbbLCVONcP0yLV47NKyi7HSs76VMihHuNtpcdWRpUyv\n"
                + "i33lgFDuRR2eIdZBJ63RaNjfZBEEaGoZqWcFwL9woHs6Qs0ykVW47ARaq31GHo38\n"
                + "Otj+VztXh5UPSci+zu3yW1G36IPOpaRcAtHk/2qoqkZ5lLYrPIn4QOq59FXOBpuj\n"
                + "x6DFyXFIaC+E5KZUCPKynsahiy0v3Tx3myxTXNjaJtFgrBgTE7zhWoOoRY6v9R+L\n"
                + "gKA8PTPRQQdQSoinlBxGDGcvyfYgia4=\n" + "-----END CERTIFICATE-----\n" + "-----BEGIN CERTIFICATE-----\n"
                + "MIIC4zCCAcugAwIBAgIhAJHFtBSRpax3l8QX8mbBYsAqNP9aYmQhH8X3/8yVdmmb\n"
                + "MA0GCSqGSIb3DQEBCwUAMBsxDDAKBgNVBAMMA1JTQTELMAkGA1UEBhMCQ04wIBcN\n"
                + "MjQxMTExMTYwMDAwWhgPMjA1MjEyMzExNTU5NTlaMBsxDDAKBgNVBAMMA1JTQTEL\n"
                + "MAkGA1UEBhMCQ04wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCro/KP\n"
                + "zoKYKKMGGbsbWvYQLX+WNWzKr6tIDvys/tesIeEraxhcDy0MydESP/Sj/p8rBjgf\n"
                + "Xwvj1kIhMeW3w3P6XF5tv9hMfs7XZB99qj+oFOOwwfylMZsipSoa26emMD+qJM73\n"
                + "e/8pdp8udJHTQxbUbz2xeDqjC6apIqENhuzDKZzjre0ub/ZTAZrnB9xwtowoUq6J\n"
                + "Pbza5/hzkv3St5m0VdvXifJ5wKcR564QWth0a/vErh5Cum3z9Z9aEQ0r+gxKpH/7\n"
                + "8xyul6DPS3NDQ/fWJeMIUVmzB3XbcBM1MUfnVtwz8VPW02LGBOtATDIb6zF6x3ov\n"
                + "Ic29w1CJj7Z4r927AgMBAAGjEDAOMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEL\n"
                + "BQADggEBAGa8rltFwfixScmJBjljlAgtYxOfXW/tbI1qxC6ObjSsR/6Dh+wQbG49\n"
                + "pEidpTpdgVO4bKy4kGs+rkbbLCVONcP0yLV47NKyi7HSs76VMihHuNtpcdWRpUyv\n"
                + "i33lgFDuRR2eIdZBJ63RaNjfZBEEaGoZqWcFwL9woHs6Qs0ykVW47ARaq31GHo38\n"
                + "Otj+VztXh5UPSci+zu3yW1G36IPOpaRcAtHk/2qoqkZ5lLYrPIn4QOq59FXOBpuj\n"
                + "x6DFyXFIaC+E5KZUCPKynsahiy0v3Tx3myxTXNjaJtFgrBgTE7zhWoOoRY6v9R+L\n"
                + "gKA8PTPRQQdQSoinlBxGDGcvyfYgia4=\n" + "-----END CERTIFICATE-----\n";
        System.out.println(X509CertUtils.parseCertificates(cert));
    }
}
