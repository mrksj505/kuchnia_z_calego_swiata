package com.kuchnia3.user;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

	@Autowired
	UserRepository userRepository;

	private static final String userSessionKey = "user";

	public User getUserFromSession(HttpSession session) {
		Integer userId = (Integer) session.getAttribute(userSessionKey);
		if (userId == null) {
			return null;
		}

		Optional<User> user = Optional.of(userRepository.getUserById(userId));

		if (user.isEmpty()) {
			return null;
		}

		return user.get();
	}

	private static void setUserInSession(HttpSession session, User user) {
		session.setAttribute(userSessionKey, user.getId());
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLoginForm(ModelAndView mav) {
		LoginFormDTO loginDTO = new LoginFormDTO();
		mav.addObject("loginDTO", loginDTO);
		mav.setViewName("login");
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView displayRegistrationForm(ModelAndView mav) {
		RegisterFormDTO registerDTO = new RegisterFormDTO();
		mav.addObject("registerDTO", registerDTO);
		mav.setViewName("register");
		return mav;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLoginForm(@ModelAttribute LoginFormDTO loginFormDTO, HttpServletRequest request, HttpSession session) {

		User theUser = userRepository.getUserByName(loginFormDTO.getUsername());

		if (theUser == null) {
			session.setAttribute("errorLogin", "Nazwa lub Hasło jest niepoprawne");
			return "redirect:";
		}

		String password = loginFormDTO.getPassword();

		if (!theUser.isMatchingPassword(password)) {
			session.setAttribute("errorLogin", "Nazwa lub Hasło jest niepoprawne");
			return "redirect:";
		}

		setUserInSession(request.getSession(), theUser);

		return "redirect:/";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistrationForm(@ModelAttribute RegisterFormDTO registerFormDTO, HttpSession session,
			HttpServletRequest request) {

		User existingUser = userRepository.getUserByName(registerFormDTO.getUsername());

		if (existingUser != null) {
			session.setAttribute("errorUsername", "Użytkownik z taką nazwą istnieje");
			return "redirect:";
		}

		String password = registerFormDTO.getPassword();
		String verifyPassword = registerFormDTO.getVerifyPassword();
		
		if (!(password.equals(verifyPassword))) {
			session.setAttribute("errorPasswords", "Hasła nie są identyczne");
			return "redirect:";
		}

		User newUser = new User(registerFormDTO.getUsername(), registerFormDTO.getPassword());
		userRepository.saveUser(newUser);
		setUserInSession(request.getSession(), newUser);

		return "redirect:/login";
	}
}
