/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolb;

/**
 *
 * @author chaqui
 */
public class Pagina {
    private Dato[] datos;
    private Pagina[] hijos;
    private int max,min,elementos;
    private Pagina padre;
    private int id;

    public Pagina(int max, Pagina padre) {
        this.max = max;
        this.min = max/2;
        this.padre = padre;
        this.elementos=0;        
        datos= new Dato[max];
        hijos = new Pagina[max+1];
    }
    public Pagina insertar(Dato datoInsertar){
        
        //Si no tiene padre porque es raiz
        if (this.padre==null) {
            return this.ingresarEnRaiz(datoInsertar);
        }
        else{
            
        }
        return null;
    }
    private Pagina ingresarEnRaiz(Dato datoInsertar){
        boolean bandent=false;
            //si no tiene hijo 1 es porque no tiene hijos
                  bandent=(this.hijos[1]==null)?true:false;
                  if (bandent) {
                        // si no esta lleno es porque todavia podemos ingresar un valor
                        if (this.elementos<this.max) {
                            this.datos[this.elementos]= datoInsertar;
                            boolean bandera=true;
                            while (bandera) {
                                bandera=false;
                                for (int i = 1; i < this.elementos; i++) {
                                    if (this.datos[i].getId() <this.datos[i-1].getId()) {
                                        Dato aux = this.datos[i];
                                        this.datos[i]=this.datos[i-1];
                                        this.datos[i-1]=aux;
                                        bandera=true;
                                    }
                                }
                            }
                            this.elementos++;
                            return null;
                        }
                         // si no es que esta llena la pagina y se debe de dividir
                        else{
                            Dato[] auxiliar = new Dato[max+1];
                            for (int i = 0; i < max; i++) {
                                auxiliar[i]= this.datos[i];
                            }
                            auxiliar[max]=datoInsertar;
                            boolean bandera=true;
                            while (bandera) {
                                bandera=false;
                                for (int i = 1; i <= max; i++) {
                                    if (auxiliar[i].getId() <auxiliar[i-1].getId()) {
                                        Dato aux = this.datos[i];
                                        auxiliar[i]=this.datos[i-1];
                                        auxiliar[i-1]=aux;
                                        bandera=true;
                                    }
                                }
                            }
                            for (int i = 0; i < max; i++) {
                                this.datos[i]=null;
                            }
                                this.datos[1]=auxiliar[max%2+1];
                                this.hijos[1]= new Pagina(max,this);
                                for (int i = 0; i < max%2+1; i++) {
                                    hijos[1].insertar(auxiliar[i]);
                                }
                                this.hijos[2]= new Pagina(max,this);
                                for (int i = 0; i < max%2+1; i++) {
                                    hijos[2].insertar(auxiliar[i]);
                                }
                           this.elementos=1;
                            
                        }  
                    }
                    else{
                        if (this.elementos<this.max) {
                            boolean banIng=false;
                            for (int i = 0; i < this.elementos; i++) {
                                if (datoInsertar.getId()<this.datos[i].getId()) {
                                    this.hijos[i]
                                }
                            }
                        } 
                        else{
                            if (this.hijos[max]!=null) {
                                Pagina a=this.hijos[max].insertar(datoInsertar);
                                if (a!=null) {
                                    this.hijos=a.hijos;
                                    this.elementos=a.elementos;
                                    this.elementos=a.elementos;
                                }
                            }   
                            else{
                                Dato[] auxiliar = new Dato[max+1];
                                for (int i = 0; i < max; i++) {
                                auxiliar[i]= this.datos[i];
                                }
                                auxiliar[max]=datoInsertar;
                                boolean bandera=true;
                                while (bandera) {
                                    bandera=false;
                                    for (int i = 1; i <= max; i++) {
                                        if (auxiliar[i].getId() <auxiliar[i-1].getId()) {
                                            Dato aux = this.datos[i];
                                            auxiliar[i]=this.datos[i-1];
                                            auxiliar[i-1]=aux;
                                            bandera=true;
                                        }
                                    }
                                }
                                for (int i = 0; i < max; i++) {
                                    this.datos[i]=null;
                                }
                                    this.datos[1]=auxiliar[max%2+1];
                                    this.hijos[1]= new Pagina(max,this);
                                    for (int i = 0; i < max%2+1; i++) {
                                        hijos[1].insertar(auxiliar[i]);
                                    }
                                    this.hijos[2]= new Pagina(max,this);
                                    for (int i = 0; i < max%2+1; i++) {
                                        hijos[2].insertar(auxiliar[i]);
                                    }
                            }
                        }
                    }
                    return null;
                }
    
            }
