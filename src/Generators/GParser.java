package Generators;

public class GParser {
    public static void main(String[] args) {
        try {
            java_cup.Main.main(
                    new String[] {
                            "-destdir",
                            "src/Language",
                            "-symbols",
                            "Terminal",
                            "-parser",
                            "Parser",
                            "src/Language/Parser.cup"
                    });
            // java -jar java-cup-lib.jar -destdir src/Language -symbols Terminal -parser
            // Parser strc/Language.Parser.cup
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
