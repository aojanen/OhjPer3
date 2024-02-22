/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.jsoncountries;

/**
 *
 * @author ttakoj
 */
public class Country implements Comparable<Country> {

	private String name;
	private double area;
	private long population;
	private double gdp;

	public Country(String name, double area, long population, double gdp) {
		this.name = name;
		this.area = area;
		this.population = population;
		this.gdp = gdp;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public void setGdp(double gdp) {
		this.gdp = gdp;
	}

	@Override
	public int compareTo(Country other) {
		return this.name.compareTo(other.name);
	}

	@Override
	public String toString() {
		return String.format("%s%n  Area: %.1f%n  Population: %d%n  GDP: %.1f", name, area, population, gdp);
	}

	// Getter methods
	public String getName() {
		return name;
	}

	public double getArea() {
		return area;
	}

	public long getPopulation() {
		return population;
	}

	public double getGdp() {
		return gdp;
	}

}
