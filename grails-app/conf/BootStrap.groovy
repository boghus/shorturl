import com.boghusdev.Usuario
import com.boghusdev.UsuarioRol
import com.boghusdev.Rol

class BootStrap {

    def init = { servletContext ->

      def adminRole = new Rol('ROLE_ADMIN').save()
      def userRole = new Rol('ROLE_USER').save()

      def testUser = new Usuario('admin', 'admin').save()

      UsuarioRol.create(testUser, adminRole, true)

      assert Usuario.count() == 1
      assert Rol.count() == 2
      assert UsuarioRol.count() == 1
   }
}
