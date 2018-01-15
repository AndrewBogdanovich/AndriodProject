package com.andrewbogdanovich.github.andriodproject.ImageLoader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileStreamProvider implements StreamProvider<File> {
    private static final int BUFFER_SIZE = 4096;

    @Override
    public InputStream get(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream(file), BUFFER_SIZE);
        return bufferedInputStream;
    }
}