package com.example.demo.payload.response;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageResponse.
 */
public class MessageResponse {
	
	/** The message. */
	private String message;

	/**
	 * Instantiates a new message response.
	 *
	 * @param message the message
	 */
	public MessageResponse(String message) {
		this.message = message;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
