public abstract class Entity
{
	/* 
	 * Base abstract entity class
	 * 
	 * Monster and Player classes extend this class
	 * 
	 * A quick note on desired direction:
	 * The direction a player is actually going is `direction`,
	 * and that should be used for calculating where they will be moving
	 * etc.
	 * `desired_direction` is the direction the player has indicated
	 * they want to be moving, but as the game uses pacman style gameplay
	 * if a wall happens to be in the way and they cannot turn, then their
	 * `desired_direction` and actual `direction` will be different, and each
	 * tick their position and `desired_direction` needs to be checked to see if
	 * their `direction` can be updated so they can start moving in their
	 * `desired_direction`
	 */
	
	private int direction;
	private int desired_direction;

	private int pos_x, pos_y; // I renamed it from x,y.
	

	public Entity()
	{	
		/*
		 * 0 = LEFT
		 * 1 = UP
		 * 2 = RIGHT
		 * 3 = DOWN
		 */
		direction = 0;
		desired_direction = 0;		
		return;
	}
	
	public void move(Entity player) 
	{
		// JUST A SAMPLE
		this.direction = 0; // LEFT
		
		// DEBUG, find out the current player coordinate
		System.out.print(player.get_pos_x() + ",");
		System.out.println(player.get_pos_y()); 
		
		switch (direction) 
		{
		// (x, y - 1) LEFT
		case 0:
			if (check_move(player.get_pos_x(), player.get_pos_y() - 1))
				// Update the player position if valid
				player.set_pos_y(player.get_pos_y() - 1);
			break;

		// (x - 1, y) UP
		case 1:
			if (check_move(player.get_pos_x() - 1, player.get_pos_y()))
				// Update the player position if valid
				player.set_pos_x(player.get_pos_x() - 1);
			break;

		// (x, y + 1) RIGHT
		case 2:
			if (check_move(player.get_pos_x(), player.get_pos_y() + 1))
				// Update the player position if valid
				player.set_pos_y(player.get_pos_y() + 1);
			break;

		// (x + 1, y) DOWN
		case 3:
			if (check_move(player.get_pos_x() + 1, player.get_pos_y()))
				// Update the player position if valid
				player.set_pos_x(player.get_pos_x() + 1);
			break;

		default:
			System.out.println("INVALID KEY WAS PRESSED");
		}

		// DEBUG, find out the current player coordinate
		System.out.print(player.get_pos_x() + ",");
		System.out.println(player.get_pos_y()); 

	}

	// shouldnt be static but oh well, we will need to move this elsewhere
	public boolean check_move(int x, int y) 
	{
		/*
		 * Maybe we can check to see if this coordinate exists/valid e.g. By moving from
		 * coordinate point (5,1) -> (5,9) via teleport Check to see if 5,9 exists as a
		 * coordinate, and if the player can move there. Meaning there is no player
		 * currently occupying that spot
		 */

		return true;
	}
		
	
	
	public int get_dir()
	{
		return direction;
	}
	
	public void set_dir(int dir)
	{
		this.direction = dir;
	}
	
	public int get_ddir()
	{
		return desired_direction;
	}
	
	public void set_ddir(int ddir)
	{
		this.desired_direction = ddir;
	}
	
	
	
	
	

	public int get_pos_x()
	{
		return this.pos_x;
	}
	
	public void set_pos_x(int pos_x)
	{
		this.pos_x = pos_x;
	}
	
	public int get_pos_y()
	{
		return this.pos_y;
	}
	
	public void set_pos_y(int pos_y)
	{
		this.pos_y = pos_y;
	}

}
