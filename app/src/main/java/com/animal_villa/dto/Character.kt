package com.animal_villa.dto
/**
 * A class Character is noun class Data Transfer Object.
 * @property name the name for every Character : String
 * @property age the age for every Character : Int
 * @property job the job for every Character : String
 */
data class Character(var name : String, var age : Int, var job : String) {
    /**
     * Contains all the methods for data class Character
     */

    /**
     * This returns the character's name and job as a string.
     * Helps in debugging errors and acts as a printable placeholder
     *
     * @return: name and job
     * character's name and job concatenated
     */
    override fun toString(): String {
        return name.plus(" ").plus(job)
    }
}