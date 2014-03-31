package clases;
// Generated 25-mar-2014 9:05:28 by Hibernate Tools 3.6.0


import java.math.BigDecimal;

/**
 * DatosempleadosId generated by hbm2java
 */
public class DatosempleadosId  implements java.io.Serializable {


     private String apellido;
     private BigDecimal salarioanual;
     private Long salario;
     private String oficio;
     private String fechaalta;
     private String departamento;

    public DatosempleadosId() {
    }

    public DatosempleadosId(String apellido, BigDecimal salarioanual, Long salario, String oficio, String fechaalta, String departamento) {
       this.apellido = apellido;
       this.salarioanual = salarioanual;
       this.salario = salario;
       this.oficio = oficio;
       this.fechaalta = fechaalta;
       this.departamento = departamento;
    }
   
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public BigDecimal getSalarioanual() {
        return this.salarioanual;
    }
    
    public void setSalarioanual(BigDecimal salarioanual) {
        this.salarioanual = salarioanual;
    }
    public Long getSalario() {
        return this.salario;
    }
    
    public void setSalario(Long salario) {
        this.salario = salario;
    }
    public String getOficio() {
        return this.oficio;
    }
    
    public void setOficio(String oficio) {
        this.oficio = oficio;
    }
    public String getFechaalta() {
        return this.fechaalta;
    }
    
    public void setFechaalta(String fechaalta) {
        this.fechaalta = fechaalta;
    }
    public String getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DatosempleadosId) ) return false;
		 DatosempleadosId castOther = ( DatosempleadosId ) other; 
         
		 return ( (this.getApellido()==castOther.getApellido()) || ( this.getApellido()!=null && castOther.getApellido()!=null && this.getApellido().equals(castOther.getApellido()) ) )
 && ( (this.getSalarioanual()==castOther.getSalarioanual()) || ( this.getSalarioanual()!=null && castOther.getSalarioanual()!=null && this.getSalarioanual().equals(castOther.getSalarioanual()) ) )
 && ( (this.getSalario()==castOther.getSalario()) || ( this.getSalario()!=null && castOther.getSalario()!=null && this.getSalario().equals(castOther.getSalario()) ) )
 && ( (this.getOficio()==castOther.getOficio()) || ( this.getOficio()!=null && castOther.getOficio()!=null && this.getOficio().equals(castOther.getOficio()) ) )
 && ( (this.getFechaalta()==castOther.getFechaalta()) || ( this.getFechaalta()!=null && castOther.getFechaalta()!=null && this.getFechaalta().equals(castOther.getFechaalta()) ) )
 && ( (this.getDepartamento()==castOther.getDepartamento()) || ( this.getDepartamento()!=null && castOther.getDepartamento()!=null && this.getDepartamento().equals(castOther.getDepartamento()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getApellido() == null ? 0 : this.getApellido().hashCode() );
         result = 37 * result + ( getSalarioanual() == null ? 0 : this.getSalarioanual().hashCode() );
         result = 37 * result + ( getSalario() == null ? 0 : this.getSalario().hashCode() );
         result = 37 * result + ( getOficio() == null ? 0 : this.getOficio().hashCode() );
         result = 37 * result + ( getFechaalta() == null ? 0 : this.getFechaalta().hashCode() );
         result = 37 * result + ( getDepartamento() == null ? 0 : this.getDepartamento().hashCode() );
         return result;
   }   


}

