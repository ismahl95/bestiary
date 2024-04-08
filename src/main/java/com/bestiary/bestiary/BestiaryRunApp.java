package com.bestiary.bestiary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bestiary.bestiary.entity.Beast;
import com.bestiary.bestiary.service.BeastService;
import com.bestiary.bestiary.service.QueryBeastService;

@Component
public class BestiaryRunApp {

  @Autowired
	BeastService beastService;
	
	@Autowired
	QueryBeastService queryBeastService;

	@Autowired
	BestiaryHelp help;

  public void run(String[] args) {

		if (args.length < 1) {
			System.out.println("Error de sintaxis");
			System.out.println(help.getHelp());
		} else if (args.length == 1) {
			switch (args[0].toLowerCase()) {
			case "-ab":
      beastService.findAllBeasts().forEach(System.out::println);
				break;
			case "-h":
				System.out.println(help.getHelp());
				break;
			default:
				System.out.println("Error de sintaxis");
				System.out.println(help.getHelp());

			}
		} else if (args.length % 2 != 0) {
			System.out.println("Error de sintaxis");
			System.out.println(help.getHelp());
		} else if (args.length > 8) {
			System.out.println("Error de sintaxis");
			System.out.println(help.getHelp());
		} else {

			// De esta forma hemos asegurado que el número de argumentos
			// es par (opción valoropción) y que no hay más de cuatro
			// parejas (ver fichero de ayuda).
			List<String[]> argumentos = new ArrayList<>();

			for (int i = 0; i < args.length; i += 2) {
				argumentos.add(new String[] { args[i], args[i + 1] });
			}
			
			boolean error = false;

			for (String[] argumento : argumentos) {
				switch (argumento[0].toLowerCase()) {
				case "-nm":
					queryBeastService.anyName(argumento[1]);
					break;
				case "-ty":
          queryBeastService.type(argumento[1].split(","));
					break;
				case "-lo":
          queryBeastService.location(argumento[1].split(","));
					break;
				case "-nl":
          queryBeastService.level(Integer.parseInt(argumento[1]));
					break;
				case "-st":
          queryBeastService.strength(argumento[1].split(","));
					break;
        case "-wk":
          queryBeastService.weakness(argumento[1].split(","));
					break;
				default: error = true;
						 System.out.println("Error de sintaxis");
						 System.out.println(help.getHelp());
				}

			}
			
			if (!error) {
				Collection<Beast> result = queryBeastService.exec();
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\n",
					"Nombre","Tipo", "Descripción", "Ubicación", "Nivel", "Resistencias", "Debilidades");
				if (result != null) {
					result.forEach(f -> System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\n", 
							f.getNombre(), 
							f.getTipo(), 
							f.getDescripcion(), 
							f.getUbicación().stream().collect(Collectors.joining(", ")),
							f.getNivel(),
							f.getResistencias().stream().collect(Collectors.joining(", ")),
							f.getDebilidades().stream().collect(Collectors.joining(", "))
							));
				} else {
					System.out.println("No hay bestias que cumplan esos criterios. Lo sentimos");
				}
			}
		}

	}
  
}
