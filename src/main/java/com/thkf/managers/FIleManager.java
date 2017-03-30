package com.thkf.managers;

import java.io.IOException;
import java.nio.file.*;

public class FIleManager {

    public static String C_DRIVE;
    public static String TEMP_FOLDER;
    public static String HOME_FOLDER;
    public static String CURRENT_FOLDER;

    static {
        C_DRIVE = System.getenv("SystemDrive");
        TEMP_FOLDER = System.getProperty("java.io.tmpdir");
        CURRENT_FOLDER = System.getProperty("user.dir");
        HOME_FOLDER = System.getProperty("user.home");
    }

    public static boolean exists(String url) {
        return Files.exists(Paths.get(url));
    }

    public static boolean exists(Path url)  {
        return Files.exists(url);
    }

    public static boolean exists(String directory, String fileName) {
        return Files.exists(Paths.get(directory, fileName));
    }

    public static boolean exists(Path directory, String fileName) {
        return Files.exists(Paths.get(directory.toString(), fileName));
    }

    public static Path getPath(String url) {
        return Paths.get(url);
    }

    public static Path createDirectory(String dirName) throws IOException {
        if(exists(dirName))
            return Paths.get(dirName);

        return Files.createDirectory(Paths.get(dirName));
    }

    public static Path createDirectory(Path dirName) throws IOException {
        if(exists(dirName))
            return dirName;

        return Files.createDirectory(dirName);
    }

    public static Path createSubDirectory(String directory, String dirName) throws IOException {
        if(exists(directory, dirName))
            return Paths.get(directory, dirName);

        return Files.createDirectory(Paths.get(directory, dirName));
    }

    public static Path createSubDirectory(Path directory, String dirName) throws IOException {
        if(exists(directory, dirName))
            return Paths.get(directory.toString(), dirName);

        return Files.createDirectory(Paths.get(directory.toString(), dirName));
    }

    public static Path createFile(String fileName) throws IOException {
        if(exists(fileName))
            return Paths.get(fileName);

        return Files.createFile(Paths.get(fileName));
    }

    public static Path createFile(String directory, String fileName) throws IOException {
        if(exists(directory, fileName))
            return Paths.get(directory, fileName);

        return Files.createFile(Paths.get(directory, fileName));
    }

    public static Path createFile(Path directory, String fileName) throws IOException {
        if(exists(directory, fileName))
            return Paths.get(directory.toString(), fileName);

        return Files.createFile(Paths.get(directory.toString(), fileName));
    }

    public static Path copy(String source, String target) throws IOException {
        return Files.copy(Paths.get(source), Paths.get(target), StandardCopyOption.REPLACE_EXISTING);
    }

    @SuppressWarnings("Contract")
    public static Path copy(Path source, Path target) throws IOException {
        return Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }

    public static Path copy(String source, String target, CopyOption... options) throws IOException {
        return Files.copy(Paths.get(source), Paths.get(target), options);
    }

    @SuppressWarnings("Contract")
    public static Path copy(Path source, Path target, CopyOption... options) throws IOException {
        return Files.copy(source, target, options);
    }

    public static Path move(String source, String target) throws IOException {
        return Files.move(Paths.get(source), Paths.get(target), StandardCopyOption.ATOMIC_MOVE);
    }

    @SuppressWarnings("Contract")
    public static Path move(Path source, Path target) throws IOException {
        return Files.move(source, target, StandardCopyOption.ATOMIC_MOVE);
    }

    public static Path move(String source, String target, CopyOption... options) throws IOException {
        return Files.move(Paths.get(source), Paths.get(target), options);
    }

    @SuppressWarnings("Contract")
    public static Path move(Path source, Path target, CopyOption... options) throws IOException {
        return Files.move(source, target, options);
    }

    public static boolean delete(Path path) throws IOException {
        return Files.deleteIfExists(path);
    }

}
