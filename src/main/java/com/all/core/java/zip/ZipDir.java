package com.all.core.java.zip;

//https://www.codejava.net/java-se/file-io/how-to-compress-files-in-zip-format-in-java
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDir extends SimpleFileVisitor<Path> {

	private static final Logger logger = Logger.getLogger(ZipDir.class.getName());

	private static ZipOutputStream zos;

	private Path sourceDir;

	public ZipDir(Path sourceDir) {
		this.sourceDir = sourceDir;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {

		try {
			Path targetFile = sourceDir.relativize(file);

			zos.putNextEntry(new ZipEntry(targetFile.toString()));

			byte[] bytes = Files.readAllBytes(file);
			zos.write(bytes, 0, bytes.length);
			zos.closeEntry();

		} catch (IOException ex) {
			System.err.println(ex);
		}

		return FileVisitResult.CONTINUE;
	}

	public static void main(String[] args) {
		String dirPath = args[0];
		Path sourceDir = Paths.get(dirPath);

		try {
			String zipFileName = dirPath.concat(".zip");
			zos = new ZipOutputStream(new FileOutputStream(zipFileName));

			Files.walkFileTree(sourceDir, new ZipDir(sourceDir));

			zos.close();
		} catch (IOException ex) {
			System.err.println("I/O Error: " + ex);
		}
	}
}
