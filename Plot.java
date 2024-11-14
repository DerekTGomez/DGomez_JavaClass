/*

* Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description: Plot class to make a rectangle plot from 4 numbers

 * Due: 11/13/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

* independently. I have not copied the code from a student or  
* any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

*/

public class Plot {

	// Instance variables to represent the x and y coordinates of the upper left
	// corner of the location,
	// and depth and width to represent the vertical and horizontal extents of the
	// plot
	
	
	//this is all assuming the coordinate is the bottom left point of the plot like in the images in the google doc
	// the doc itself says top left point is (x,y) but this is contradicted by the gfa and the images inside the doc
	private int x = 0, y = 0, width = 0, depth = 0;

	// origin == (0,0)

	// constructors

	// Creates a default Plot with width and depth of 1
	public Plot() {

		// origin == (0,0)
		x = y = 0;
		width = depth = 1;

	}

	// Creates a Plot using the given values.
	public Plot(int x, int y, int width, int depth) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	// Creates a new plot given another plot. This constructor must call an
	// appropriate existing constructor.
	public Plot(Plot otherPlot) {

		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;

	}

	// accessors

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getDepth() {
		return depth;
	}

	// setters / mutators

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	// Determines if the given plot instance is overlapped by the current plot
	// returns true if overlap

	public boolean overlaps(Plot plot) {

		
		
		
		if (this.x + this.width <= plot.x || plot.x + plot.width <= this.x ||
		        this.y + this.depth <= plot.y || plot.y + plot.depth <= this.y) {
		        return false; // No overlap
		    }
		    
		
		    return true;

		}
	

	// Determines if the given plot is encompassed by (is contained by) this plot
	// if an edge lies on the edge of the current plot, this is acceptable
	public boolean encompasses(Plot plot) {

		boolean tester = false;

		// test to see if this plot is within the bounds of the parameter
		if (this.x >= plot.x && ((this.x + this.width) <= (plot.x + plot.width))) {

			// checking the top and bottom
			if (this.y >= plot.y && ((this.y + this.depth) <= (plot.y + plot.depth))) {
				tester = true;
			}
		}

		// have to do the reverse too because the other graph could be encompassed
		if (plot.x >= this.x && ((plot.x + plot.width) <= (this.x + this.width))) {

			if (plot.y >= this.y && ((plot.y + plot.depth) <= (this.y + this.depth))) {
				tester = true;
			}

		}

		return tester;
	}

	public String toString() {

		return (this.x + "," + this.y + "," + this.width + "," + this.depth);
	}

	@Override
	public boolean equals(Object o) {

		if (o instanceof Plot) {

			Plot temp = (Plot) o;

			return (x == temp.x && y == temp.y && width == temp.width && depth == temp.depth);
		}
		return false;
	}

}
