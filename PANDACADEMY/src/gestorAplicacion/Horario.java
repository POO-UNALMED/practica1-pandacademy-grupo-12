package gestorAplicacion;

public class Horario {
    
    private String dia, HoraInicio, HoraFinal;

    public Horario(String d, String i, String f){
        this.dia = d;
        this.HoraFinal = f;
        this.HoraInicio = i;
    }

    public String getDia(){
        return this.dia;
    }

    public String getInicio() {
        return this.HoraInicio;
    }

    public String getFinal(){
        return this.HoraFinal;
    }

    public int getHoras() {
        int inicio = Integer.parseInt(this.HoraInicio.substring(0, 1));
        int fin = Integer.parseInt(this.HoraFinal.substring(0, 1));
        return fin-inicio;
    }

    public String toString() {
        String horario = this.getDia() + "\n" + this.getInicio() + "\n" + this.getFinal();
        return horario;        
    }
}
