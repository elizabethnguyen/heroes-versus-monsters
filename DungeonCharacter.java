import java.util.*;

public class DungeonCharacter
{
    // members
    protected String _name;
    protected String _class_type;
    protected int _hit_points;
    protected int _speed;
    protected int _min_dmg;
    protected int _max_dmg;
    protected double _hit_chance;
    protected Scanner _scan;
    protected Random _gen;

    // name: constructor
    // desc: sets _scan and _gen
    // params: Scanner scan, Random gen
    // return: n/a
    // 1) _scan = scan;
    // 2) _gen = gen;

    public DungeonCharacter(Scanner scan, Random gen)
    {
	_scan = scan;
	_gen = gen;
    }

    // name: attack
    // desc: generates a random number to determine if the character attacks.
    // If it checks, then a random number is generated between max and min to
    // deal damage to the enemy.
    // params: Monster enemy
    // return: void
    // 1) chance = _gen.nextDouble();
    // 2) if ( chance <= _hit_chance)
    // 3) damage = Math.abs(_gen.nextInt(_max_dmg - _min_dmg) + _min_dmg);

    public void attack(Monster enemy)
    {
	double chance;
	int damage;
	chance = _gen.nextDouble();

	if (chance <= _hit_chance)
	    {
		damage = Math.abs(_gen.nextInt(_max_dmg - _min_dmg) + _min_dmg);
		System.out.println(_name + " the " + _class_type + " deals " + damage + " points of damage!");
		enemy.take_damage(damage);
	    }
	else
	    {
		System.out.println( _name + " the " + _class_type + "'s attack missed!");
		System.out.println(enemy.toString());
	    }

    }

    // name: take_damage
    // desc: The character takes damage if attack passes.
    // params: int damage
    // return: void
    // 1) _hit_points -= damage;
    // 2) System.out.println(toString());

    public void take_damage(int damage)
    {
	_hit_points -= damage;
	System.out.println(toString());
    }

    // name: toString
    // desc: Prints the character and the health remaining.
    // params: none
    // return: String
    // 1) String info = _name + " has " + _hit_points + " health reamining.";
    // 2) return info;

    public String toString()
    {
	String info = _name + " has " + _hit_points + " health remaining.";
	return info;
    }

}
