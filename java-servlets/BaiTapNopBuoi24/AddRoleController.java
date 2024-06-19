package crm06.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm06.entity.RoleEntity;
import crm06.service.RoleService;

@WebServlet(name="addRoleController", urlPatterns= {"/add-role"})
public class AddRoleController extends HttpServlet {
	private RoleService roleService = new RoleService();
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.getRequestDispatcher("role-add.jsp").forward(req, res);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("roleName");
		String description = req.getParameter("roleDescription");
		
		System.out.println(name);
		System.out.println(description);
		
		RoleEntity role = new RoleEntity();
		role.setName(name);
		role.setDescription(description);
		
		roleService.addRole(role);
	}
}
