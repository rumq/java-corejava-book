package pawarv;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

/**
 *  Demonstrates how to use Files.walk, Files.find, Files.list, 
 *  and Files.walkFileTree
 */
public class FilesDirectoryVisitorTest {

    public static void main(String[] args) throws IOException {

        // walk
        System.out.println("Files.walk");
        try (Stream<Path> entries = Files.walk(Path.of("book-code"))) {
            entries.forEach(System.out::println);
        }

        // find
        System.out.println("Files.find");
        try (Stream<Path> entries = Files.find(
                Path.of("book-code"),
                3,
                (path, attr) -> path.toString().endsWith(".java"))) {
            entries.forEach(System.out::println);
        }

        // list
        System.out.println("Files.list");
        try (Stream<Path> entries = Files.list(Path.of("book-code"))) {
            entries.forEach(System.out::println);
        }

        // walkFileTree

        // walkFileTree
        System.out.println("Files.walkFileTree");
        Files.walkFileTree(Path.of("book-code"), new DirectoryVisitor());

    }

}

class DirectoryVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file);

        if (attrs.isDirectory()) {
            return FileVisitResult.SKIP_SUBTREE;
        } else {
            System.out.println("File: " + file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

}
