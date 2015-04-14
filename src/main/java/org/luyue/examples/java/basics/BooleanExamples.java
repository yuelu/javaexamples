package org.luyue.examples.java.basics;

/**
 * <pre>
 * 1). boolean parseBoolean(String s): returns true when the string argument is not null and is equalsIgnoreCase to the string "true".
 * 2). Boolean valueOf(String s): returns Boolean.TRUE when the string argument is not null and is equalsIgnoreCase to the string "true".
 * 3). boolean getBoolean(String name): returns true when the system property named by the argument exists and is equalsIgnoreCase to the string "true".
 * </pre>
 * 
 * @author jlu
 *
 */
public class BooleanExamples {

    public static void main(String[] args) {

        System.out.println("************* Boolean.parseBoolean ************* ");
        System.out.println("Boolean.parseBoolean(null):" + Boolean.parseBoolean(null));
        System.out.println("Boolean.parseBoolean(\"True\"):" + Boolean.parseBoolean("True"));
        System.out.println("Boolean.parseBoolean(\"false\"):" + Boolean.parseBoolean("false"));
        System.out.println("Boolean.parseBoolean(\"yes\"):" + Boolean.parseBoolean("yes"));

        System.out.println("************* Boolean.valueOf ************* ");
        System.out.println("Boolean.valueOf(null):" + Boolean.valueOf(null));
        System.out.println("Boolean.valueOf(\"True\"):" + Boolean.valueOf("True"));
        System.out.println("Boolean.valueOf(\"false\"):" + Boolean.valueOf("false"));
        System.out.println("Boolean.valueOf(\"yes\"):" + Boolean.valueOf("yes"));

        System.out.println("************* Boolean.getBoolean ************* ");
        System.out.println("Boolean.getBoolean(null):" + Boolean.getBoolean(null));
        System.out.println("Boolean.getBoolean(\"True\"):" + Boolean.getBoolean("True"));
        // set system property
        System.setProperty("booleanProp", "true");
        System.out.println("System.setProperty(\"booleanProp\", \"true\"):" + Boolean.getBoolean("booleanProp"));

        System.setProperty("booleanProp", "TrUe");
        System.out.println("System.setProperty(\"booleanProp\", \"TrUe\"):" + Boolean.getBoolean("booleanProp"));

        System.setProperty("booleanProp", "false");
        System.out.println("System.setProperty(\"booleanProp\", \"false\"):" + Boolean.getBoolean("booleanProp"));
    }
}
