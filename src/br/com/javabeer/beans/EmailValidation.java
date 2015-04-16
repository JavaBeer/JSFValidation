package br.com.javabeer.beans;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class EmailValidation implements Serializable {

	private static final long serialVersionUID = -1389645821753163001L;

	private Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void validateEmail(FacesContext context, UIComponent comp, Object value) {
		String email = (String) value;

		if (!(pattern.matcher(email)).matches()) {
			((UIInput) comp).setValid(false);
			FacesMessage message = new FacesMessage("Insira um e-mail valido");
			context.addMessage(comp.getClientId(context), message);
		}
	}
}
