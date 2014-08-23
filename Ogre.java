import java.util.*;

public class Ogre extends Monster
{

    // name: constructor
    // desc: initializes base stats and passes scan and gen to the parent
    // params: Scanner scan, Random gen
    // return: n/a
    // 1) super(scan, gen);
    // 2) Allocate _hit_points, _speed, _hit_chance, _min_dmg, _max_dmg, etc.

    public Ogre(Scanner scan, Random gen)
    {
	super(scan, gen);
	_hit_points = 200;
	_speed = 2;
	_hit_chance = .6;
	_min_dmg = 30;
	_max_dmg = 60;
	_heal_chance = .1;
	_min_heal = 30;
	_max_heal = 60;
	_class_type = "Ogre";
	_name = "Ogre";
    }

    // name: reset_for_game (OVERRIDE)
    // desc: Resets the health for the character to begin a new game
    // params: none
    // return: void
    // 1) _hit_points = 200;

   public void reset_for_game()
    {
	_hit_points = 200;
    }

}
