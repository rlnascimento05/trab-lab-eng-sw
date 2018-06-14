package br.farmacia.modelo;

public class Cosmetico extends Produto {
    private int codCosmetico;
    private String marca;
    private String uso;

    public Cosmetico(){
    	
    }
    
    public Cosmetico(int codCosmetico, String marca, String uso) {
        this.codCosmetico = codCosmetico;
        this.marca = marca;
        this.uso = uso;
    }

    //TODO: Getters and Setters

    public String getMarca() {
        return marca;
	}

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public int getCodCosmetico() {
        return codCosmetico;
    }

    public void setCodMedicamento(int codCosmetico) {
        this.codCosmetico = codCosmetico;
    }
}
