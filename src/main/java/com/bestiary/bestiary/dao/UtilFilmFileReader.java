package com.bestiary.bestiary.dao;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.ResourceUtils;

import com.bestiary.bestiary.entity.Beast;

public class UtilFilmFileReader {

	public static List<Beast> readFile(final String path, final String separator, final String listSeparator) {
		List<Beast> result = new ArrayList<>();


		try {

			result = Files
						.lines(Paths.get(ResourceUtils.getFile(path).toURI()))
						.skip(1)
						.map(line -> {
							String[] values = line.split(separator);
							return new Beast(values[0], values[1], values[2], Arrays.asList(values[3].split(listSeparator)), Integer.parseInt(values[4]),
              Arrays.asList(values[5].split(listSeparator)),Arrays.asList(values[6].split(listSeparator)));
					}).collect(Collectors.toList());

		} catch (Exception e) {
			System.err.println("Error de lectura del fichero de datos: Bestiary");
			System.exit(-1);
		}

		return result;

	}

}
