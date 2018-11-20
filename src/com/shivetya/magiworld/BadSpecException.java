package com.shivetya.magiworld;

class BadSpecException extends RuntimeException {


    BadSpecException(){
        System.out.println("Le niveau doit être compris entre 1 et 100 inclus.");
        System.out.println("La force, l'agilité et l'intellgence doivent être compris entre 0 et 100 inclus");
        System.out.println("La somme de la force, de l'agilité et de l'intelligence doit être égale au niveau");
    }
}
