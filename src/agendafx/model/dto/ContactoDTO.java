package agendafx.model.dto;


public class ContactoDTO 
{
    private int id;
    private String contacto;
    private String email;
    private String telefono;
    private String domicilio;
    private String notas;

    public ContactoDTO() 
    {
    }

    public ContactoDTO(int id, String contacto, String telefono, String email, String domicilio, String notas) {
        this.id = id;
        this.contacto = contacto;
        this.telefono = telefono;
        this.email = email;
        this.domicilio = domicilio;
        this.notas = notas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}
