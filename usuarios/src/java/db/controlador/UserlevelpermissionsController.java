package db.controlador;

import db.usuarios.Userlevelpermissions;
import db.controlador.util.JsfUtil;
import db.controlador.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("userlevelpermissionsController")
@SessionScoped
public class UserlevelpermissionsController implements Serializable {

    @EJB
    private db.controlador.UserlevelpermissionsFacade ejbFacade;
    private List<Userlevelpermissions> items = null;
    private Userlevelpermissions selected;

    public UserlevelpermissionsController() {
    }

    public Userlevelpermissions getSelected() {
        return selected;
    }

    public void setSelected(Userlevelpermissions selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getUserlevelpermissionsPK().setUserlevelid(selected.getUserlevels().getUserlevelid());
    }

    protected void initializeEmbeddableKey() {
        selected.setUserlevelpermissionsPK(new db.usuarios.UserlevelpermissionsPK());
    }

    private UserlevelpermissionsFacade getFacade() {
        return ejbFacade;
    }

    public Userlevelpermissions prepareCreate() {
        selected = new Userlevelpermissions();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UserlevelpermissionsCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UserlevelpermissionsUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("UserlevelpermissionsDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Userlevelpermissions> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Userlevelpermissions getUserlevelpermissions(db.usuarios.UserlevelpermissionsPK id) {
        return getFacade().find(id);
    }

    public List<Userlevelpermissions> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Userlevelpermissions> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Userlevelpermissions.class)
    public static class UserlevelpermissionsControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UserlevelpermissionsController controller = (UserlevelpermissionsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "userlevelpermissionsController");
            return controller.getUserlevelpermissions(getKey(value));
        }

        db.usuarios.UserlevelpermissionsPK getKey(String value) {
            db.usuarios.UserlevelpermissionsPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new db.usuarios.UserlevelpermissionsPK();
            key.setUserlevelid(Integer.parseInt(values[0]));
            key.setTablename(values[1]);
            return key;
        }

        String getStringKey(db.usuarios.UserlevelpermissionsPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getUserlevelid());
            sb.append(SEPARATOR);
            sb.append(value.getTablename());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Userlevelpermissions) {
                Userlevelpermissions o = (Userlevelpermissions) object;
                return getStringKey(o.getUserlevelpermissionsPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Userlevelpermissions.class.getName()});
                return null;
            }
        }

    }

}
