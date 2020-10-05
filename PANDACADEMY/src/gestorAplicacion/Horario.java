package gestorAplicacion;

public class Horario {
    
    private String dia, horaInicio, horaFinal;

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
        String horario = dia + "\n" + horaInicio + "\n" + horaFinal;
        return horario;        
    }
}
