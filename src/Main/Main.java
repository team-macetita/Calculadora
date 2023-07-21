package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import Language.Parser;
import Language.Scanner;
import Language.Terminal;
import Tree.Node;
import java_cup.runtime.Symbol;

public class Main {
    public static void main(String[] args) {
        try {
            String input = readInput("Input.lfp");
            // System.out.println(input);
            Scanner scanner = new Scanner(
                    new BufferedReader(
                            new StringReader(input)));
            // Symbol sym;
            // do {
            // sym = scanner.next_token();
            // System.out.println(sym.value + " - " + Terminal.terminalNames[sym.sym]);
            // } while (sym.value != null); // es solo para hacer el analisis lexico
            Parser parser = new Parser(scanner);
            parser.parse();
            // System.out.println(scanner.errors);
            // System.out.println(parser.trees);

            String dot = "digraph Trees{";
            for (int i = 0; i < parser.trees.size(); i++) {
                dot += parser.trees.get(i).getDot(i);
            }
            dot += "}";
            System.out.println("--- Argol ---\n");
            System.out.println(dot);
            // System.out.println(parser.s.errors);
            // System.out.println(parser.errors);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String readInput(String path) {
        try {
            File archivo = new File(path);
            FileInputStream fis = new FileInputStream(archivo);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String texto = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                texto += linea;
                if (br.ready()) {
                    texto += '\n';
                }
            }
            br.close();
            fis.close();
            return texto;
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }
}
