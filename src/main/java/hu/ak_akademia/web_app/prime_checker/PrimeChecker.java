package hu.ak_akademia.web_app.prime_checker;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prime")
public class PrimeChecker extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long testNumber = 0L, y = Integer.MAX_VALUE;
		try {
			testNumber = Long.parseLong(request.getParameter("prime"));
		} catch (NumberFormatException e) {
			reply(request, response, "Nem adtál meg számot ! 🤷‍♂️");
		}
		if (testNumber > y || testNumber < 1) {
			reply(request, response, testNumber < 1 ? "Nem lehet negatív szám !" : "Túl nagy szám ! 🤦‍♂️");
		} else {
			reply(request, response, "A megadott szám: %,d %s !".formatted(testNumber, isPrime(testNumber) ? "prímszám 😃" : "nem prímszám 😒"));
		}
	}

	private void reply(HttpServletRequest request, HttpServletResponse response, String result) throws ServletException, IOException {
		request.setAttribute("result", result);
		request.getRequestDispatcher("primeChecker.jsp").forward(request, response);
	}

	private static boolean isPrime(long number) {
		int root = (int) Math.sqrt(number);
		if (number % 2 == 0) {
			return number == 2;
		}
		for (int i = 3; i <= root; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
