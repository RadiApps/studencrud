package in.app.onlineassisment.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1787718001341830406L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
