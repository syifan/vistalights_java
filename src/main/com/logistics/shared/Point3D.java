/**
 * Logistics server side
 */
package com.logistics.shared;

/**
 * @author yifansun
 *
 */
public class Point3D {

	/**
	 * Coordinate of the point
	 */
	protected double x;
	protected double y;
	protected double z;
	
	/**
	 * Constructor
	 */
	public Point3D(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point3D add(Point3D p){
		return new Point3D(this.x + p.x, this.y + p.y, this.z + p.z);
	}
	
	/**
	 *  Get the angle between 2 vectors
	 */
	public double angle(Point3D p){
		Point3D p1 = this.normalize();
		Point3D p2 = p.normalize();
		double inner = p1.innerProduct(p2);
		if(Math.abs(inner - 1.0) < 1e-5){
			return 0;
		}
		double d1 = p1.length();
		double d2 = p2.length();
		double cos = inner / d1 * d2;
		double angle = Math.acos(cos);
		return angle;
	}
	
	/**
	 * Calculate the cross product of 2 vectors
	 */
	public Point3D crossProduct(Point3D p) {
		return new Point3D(this.y*p.z - this.z*p.y,
				this.z*p.x - this.x*p.z, 
				this.x*p.y - this.y*p.x);
	}
	
	/**
	 * Calculate the distance to another point
	 */
	public double distanceTo(Point3D p){
		Point3D vector = this.subtract(p);
		return vector.length();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

	/**
	 * Get a deep copy of the point
	 */
	public Point3D getCopy(){
		return new Point3D(x, y, z);
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}
	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}
	/**
	 * @return the z
	 */
	public double getZ() {
		return z;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	/**
	 * Calculate the inner product of two vector
	 */
	public double innerProduct(Point3D p){
		double ret = this.x * p.x + this.y * p.y + this.z * p.z;
		return ret;
	}
	
	/**
	 * Get the length of the vector
	 * @return
	 */
	public double length(){
		return Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
	}
	
	/**
	 * Multiply the vector with a constant
	 * @param c
	 * @return
	 */
	public Point3D multiply(double c){
		return new Point3D(this.x * c, this.y * c, this.z * c);
	}
	
	/**
	 * Get the normalized vector
	 * @return
	 */
	public Point3D normalize(){
		double nx = 0, ny = 0, nz = 0;
		double length = this.length();
		if(Math.abs(length) <= 1e-5){
			return new Point3D(0, 0, 0);
		}
		nx = this.x/length;
		ny = this.y/length;
		nz = this.z/length;
		return new Point3D(nx, ny, nz);
		
	}
	
	/**
	 * Get the orthogonal component relative to p
	 */
	public Point3D orthogonal(Point3D p)
	{
		Point3D par = this.parallel(p);
		return this.subtract(par);
	}
	
	/**
	 * Get the parallel component relative to p
	 */
	public Point3D parallel(Point3D p){
		double innerProduct = this.innerProduct(p);
		return p.normalize().multiply(innerProduct);
	}
	
	/**
	 * Rotate the vector by an angle along x, y, z axises
	 * @param angle
	 * @return
	 */
	public Point3D rotate(Point3D angle) {
		Point3D newVector = this.rotateZ(angle.getZ());
		newVector = newVector.rotateY(angle.getY());
		newVector = newVector.rotateX(angle.getX());
		return newVector;
	}
	
	/**
	 * Rotate the vector by a certain angle along the z axis
	 * @param angle
	 * @return
	 */
	public Point3D rotateX(double angle) {
		double newX = this.x;
		double newY = this.y * Math.cos(angle) - this.z * Math.sin(angle);
		double newZ = this.y * Math.sin(angle) + this.z * Math.cos(angle);
		return new Point3D(newX, newY, newZ);
	}
	
	/**
	 * Rotate the vector by a certain angle along the y axis
	 * @param angle
	 * @return
	 */
	public Point3D rotateY(double angle) {
		double newX = this.x * Math.cos(angle) + this.z * Math.sin(angle);
		double newY = this.y;
		double newZ = -this.x * Math.sin(angle) + this.z * Math.cos(angle);
		return new Point3D(newX, newY, newZ);
	}
	
	/**
	 * Rotate the vector by a certain angle along the x axis
	 * @param angle
	 * @return
	 */
	public Point3D rotateZ(double angle) {
		double newX = this.x * Math.cos(angle) - this.y * Math.sin(angle);
		double newY = this.x * Math.sin(angle) + this.y * Math.cos(angle);
		double newZ = this.z;
		return new Point3D(newX, newY, newZ);
	}
	
	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * @param z the z to set
	 */
	public void setZ(double z) {
		this.z = z;
	}
	
	/**
	 * Subtract another point from current one
	 */
	public Point3D subtract(Point3D p){
		double nx, ny, nz;
		nx = this.x - p.x;
		ny = this.y - p.y;
		nz = this.z - p.z;
		return new Point3D(nx, ny, nz);
	}
	
	/**
	 * Return the JSON representation of a point
	 * @return
	 */
	public Object toJson() {
		return String.format("{\"x\": %f, \"y\": %f, \"z\": %f}", x, y, z);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("(%4.2f, %4.2f, %4.2f)", x, y, z);
	}
	
}
