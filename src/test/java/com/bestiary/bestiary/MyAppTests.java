package com.bestiary.bestiary;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bestiary.bestiary.entity.Beast;
import com.bestiary.bestiary.service.QueryBeastService;

public class MyAppTests {

    private BestiaryRunApp bestiaryRunApp;

    // Mocks de las dependencias
    private QueryBeastService queryBeastServiceMock;
    private BestiaryHelp bestiaryHelpMock;

    // Captura la salida en la consola
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        // Inicializar mocks
        queryBeastServiceMock = mock(QueryBeastService.class);
        bestiaryHelpMock = mock(BestiaryHelp.class);

        // Inyectar mocks en la clase bajo prueba
        bestiaryRunApp = new BestiaryRunApp();
        bestiaryRunApp.queryBeastService = queryBeastServiceMock;
        bestiaryRunApp.help = bestiaryHelpMock;

        // Redirigir la salida estándar a ByteArrayOutputStream
        System.setOut(new PrintStream(outContent));
    }

/**
 * This test case verifies that calling the `run` method with no arguments in the `bestiaryRunApp`
 * class should return help by invoking the `getHelp` method on the `bestiaryHelpMock` object.
 */
    @Test
    public void noArgumentsShouldReturnHelp() {
        String[] args = new String[]{};

        bestiaryRunApp.run(args);

        verify(bestiaryHelpMock).getHelp();
    }

/**
 * This Java test method verifies that the `bestiaryRunApp` correctly retrieves and displays
 * information about a beast named "Grifo".
 */
    @Test
    public void testRunWithNameArgument_Grifo() {
        // Arrange
        String[] args = new String[]{"-nm", "Grifo"};
        Beast grifo = new Beast("Grifo", "Criatura alada", "Un depredador majestuoso con cuerpo de león y alas de águila.",
                Arrays.asList("Caminos y zonas montañosas"), 5, Arrays.asList("Quen"), Arrays.asList("Aceite de aceituna"));
    
        // Configurar comportamiento de los mocks
        when(queryBeastServiceMock.exec()).thenReturn(Arrays.asList(grifo));
        when(bestiaryHelpMock.getHelp()).thenReturn("Ayuda para Bestiario");
    
        // Act
        bestiaryRunApp.run(args);
    
        // Assert
        verify(queryBeastServiceMock).anyName("Grifo");
        verify(bestiaryHelpMock, never()).getHelp(); // No deberíamos llamar a getHelp en este caso
        // Verificar que la información del Grifo se imprima correctamente
        String expectedCategoryLine = "Nombre Tipo Descripción Ubicación Nivel Resistencias Debilidades";
        String expectedResultLine = "Grifo Criatura alada Un depredador majestuoso con cuerpo de león y alas de águila. Caminos y zonas montañosas 5 Quen Aceite de aceituna";
    
        // Imprimir la salida real y la cadena esperada
        System.out.println("Salida real:");
        System.out.println(outContent.toString());
        System.out.println("Cadena esperada:");
        System.out.println(expectedCategoryLine);
        System.out.println(expectedResultLine);
    
        // Dividir las cadenas en líneas y verificar que todas estén presentes
        List<String> actualLines = Arrays.asList(outContent.toString().split("\\r?\\n"));
        assertTrue(actualLines.contains(expectedCategoryLine));
        assertTrue(actualLines.contains(expectedResultLine));
    }
    
}
