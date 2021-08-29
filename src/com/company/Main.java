package com.company;

public class Main {

    public static void main(String[] args) {

        String valor = "0x23aBh";
        String hexa = "0123456789ABCDEFabcdef";

        int estado = 0;
        for(int i = 0; i < valor.length();i++){
            switch (estado){
                case 0:
                    if(valor.charAt(i) == '0') {
                        estado = 1;
                    }else{
                        estado = 5;
                    }
                    break;
                case 1:
                    if(valor.charAt(i) == 'x' || valor.charAt(i) == 'X'){
                        estado = 2;
                    } else {
                        estado = 5;
                    }
                    break;
                case 2:
                    if(hexa.contains(String.valueOf(valor.charAt(i)))){
                        estado = 3;
                    } else {
                        estado = 5;
                    }
                    break;
                case 3:
                    if(hexa.contains(String.valueOf(valor.charAt(i)))){
                        estado = 3;
                    } else {
                        estado = 6;
                    }
                    break;
                default:
                    System.out.println("ERRO LEXICO");
                    System.exit(0);
            }
            if(estado == 5 || estado == 6){
                System.out.println("ERRO LEXICO");
                System.exit(0);
            }
        }
        if(estado == 3){
            System.out.println("Cadeia reconhecida pelo autômato!");
        } else{
            System.out.println("Cadeia não reconhecida!");
        }
    }
}
