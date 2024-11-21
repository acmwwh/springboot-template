package com.example.acmwwh.common.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchProviderException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 证书工具类
 * 
 * @author linfan
 * @since 2024/11/21
 */
public class X509CertUtils {
    private X509CertUtils() {}

    private static final String CERT_FORMAT = "X.509";

    private static CertificateFactory certificateFactory;

    static {
        try {
            certificateFactory = getCertificateFactory();
        } catch (CertificateException e) {
            throw new RuntimeException(e);
        }
    }

    public static CertificateFactory getCertificateFactory() throws CertificateException {
        certificateFactory = CertificateFactory.getInstance(CERT_FORMAT);
        return certificateFactory;
    }

    public static CertificateFactory getCertificateFactory(String providerName)
        throws CertificateException, NoSuchProviderException {
        certificateFactory = CertificateFactory.getInstance(CERT_FORMAT, providerName);
        return certificateFactory;
    }

    public static X509Certificate parseCertificate(String certInfo) throws IOException, CertificateException {
        try (InputStream inputStream = new ByteArrayInputStream(certInfo.getBytes())) {
            return parseCertificate(inputStream);
        }
    }

    public static X509Certificate parseCertificate(InputStream inputStream) throws CertificateException {
        return (X509Certificate)certificateFactory.generateCertificate(inputStream);
    }

    public static List<X509Certificate> parseCertificates(String certInfo) throws CertificateException, IOException {
        try (InputStream inputStream = new ByteArrayInputStream(certInfo.getBytes())) {
            return parseCertificates(inputStream);
        }
    }

    public static List<X509Certificate> parseCertificates(InputStream inputStream) throws CertificateException {
        List<X509Certificate> x509Certificates = new ArrayList<>();
        Collection<? extends Certificate> certificates = certificateFactory.generateCertificates(inputStream);
        for (Certificate certificate : certificates) {
            if (certificate instanceof X509Certificate) {
                x509Certificates.add((X509Certificate)certificate);
            }
        }
        return x509Certificates;
    }
}
