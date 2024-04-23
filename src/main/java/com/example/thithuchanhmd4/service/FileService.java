package com.example.thithuchanhmd4.service;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// ...

@Service
public class FileService {

    @Autowired
    private IOService ioService;
    // ...

    private static final String DIRECTORY_PATH = "C:/Users/ASUS/Downloads";

    public StreamingResponseBody test() {
        return outputStream -> {
            try (ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(outputStream))) {
                File directory = new File(DIRECTORY_PATH);

                List<CompletableFuture<Void>> list = new ArrayList<>();
                File[] files = directory.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            list.add(ioService.asyncDownloadAndZipFile(file.getPath(), zipOutputStream));
                        }
                    }
                }

                CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    // Phương thức sử dụng StreamingResponseBody
    public void test2(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(response.getOutputStream()))) {
            File directory = new File(DIRECTORY_PATH);

            File[] files = directory.listFiles();
            List<CompletableFuture<Void>> list = new ArrayList<>();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        ioService.asyncDownloadAndZipFile(file.getPath(), zipOutputStream);
                        list.add(ioService.asyncDownloadAndZipFile(file.getPath(), zipOutputStream));
                    }
                }
            }

            CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
