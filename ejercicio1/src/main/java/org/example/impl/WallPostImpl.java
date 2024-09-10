package org.example.impl;

import org.example.WallPost;

public class WallPostImpl implements WallPost {

	private String text;
	private int likes;
	private boolean featured;

	public WallPostImpl() {
		this.text = "Undefined post";
		this.likes = 0;
		this.featured = false;
	}

	/*
	 * Retorna el texto descriptivo de la publicación
	 */
	public String getText() {
		return this.text;
	}

	/*
	 * Asigna el texto descriptivo de la publicación
	 */
	public void setText(String descriptionText) {
		this.text = descriptionText;
	}

	/*
	 * Retorna cantidad de "me gusta"
	 */
	public int getLikes() {
		return this.likes;
	}

	/*
	 * Incrementa cantidad de likes en uno
	 */
	public void like() {
		this.likes++;
	}

	/*
	 * Decrementa la cantidad de likes en uno. Si ya es 0 no hace nada
	 */
	public void dislike() {
		if (this.likes > 0) {
			this.likes--;
		}
	}

	/*
	 * Retorna true si el post está marcado como destacado, false en caso contrario
	 */
	public boolean isFeatured() {
		return this.featured;
	}

	/*
	 * Cambia el post del estado destacado a no destacado y viceversa
	 */
	public void toggleFeatured() {
		this.featured = !this.featured;
	}

	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de
	 * forma adecuada
	 */
	@Override
	public String toString() {
		return "WallPost {" +
				"text: " + getText() +
				", likes: '" + getLikes() + "'" +
				", featured: '" + isFeatured() + "'" +
				"}";
	}

}
