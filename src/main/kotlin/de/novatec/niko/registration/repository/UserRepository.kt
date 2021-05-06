package de.novatec.niko.registration.repository

import org.springframework.stereotype.Component

@Component
class UserRepository {

  private val joinedUsers = mutableSetOf<String>()

  fun registerUser(userId: String) {
    joinedUsers.add(userId)
  }

  fun isRegistered(userId: String) = joinedUsers.contains(userId)

  fun getUsers() = joinedUsers

  fun deleteUser(userId: String) = joinedUsers.remove(userId)
}
