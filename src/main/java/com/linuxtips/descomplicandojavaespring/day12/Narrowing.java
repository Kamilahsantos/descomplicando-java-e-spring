package com.linuxtips.descomplicandojavaespring.day12;


public class Narrowing {

    public static void main(String[] args) {

        //nesse tipo de typecasting nós convertemos manualmente
        //um tipo de dados para outro usando o tipo desejado entre ()
        //double para int
        double meuDouble = 1.99;
        System.out.println(meuDouble);
        int meuInt = (int) meuDouble;
        System.out.println(meuInt);
        // usamos essa tecnica de narrowing quando queremos passar para um tipo menir
        //nesse caso algumas vezes se perde informacoes
        //segue a ordem: double -> float -> long -> int -> short -> byte


        //int para string
        String minhaStringInt = String.valueOf(meuInt);
        String minhaStringDouble = String.valueOf(meuDouble);
        System.out.println(minhaStringInt);
        System.out.println(minhaStringDouble);

        String s = "1";
        //para converter uma String para um tipo primitivo
        //usamos wrappers que empacotam os tipos primitivos
        boolean meuBoolean = Boolean.parseBoolean(s);
        System.out.println(meuBoolean);
        float meuFloat = Float.parseFloat(s);
        System.out.println(meuFloat);
        int meuNovoInt = Integer.parseInt(s);
        System.out.println(meuNovoInt);
        short meuShort = Short.parseShort(s);
        System.out.println(meuShort);
        long meuLong = Long.parseLong(s);
        System.out.println(meuLong);
        double meuNovoDouble = Double.parseDouble(s);
        System.out.println(meuNovoDouble);
        byte meuByte = Byte.parseByte(s);
        System.out.println(meuByte);



    }


}

