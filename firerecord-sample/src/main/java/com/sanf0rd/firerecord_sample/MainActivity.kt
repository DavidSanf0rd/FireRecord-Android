package com.sanf0rd.firerecord_sample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.firestore.ServerTimestamp
import com.sanf0rd.firerecord.*
import com.sanf0rd.firerecord.query.comparison.greaterThan
import com.sanf0rd.firerecord.query.comparison.lessThan
import com.sanf0rd.firerecord.storage.FirebaseImage

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

//        Employee.all { users ->
//            users.forEach { user ->
//                Log.d("User.name", "${user.id}")
//            }
//        }

//        Employee.load("9qWVZ4Ar1dKnikGs5aAY") { employee ->
//            Log.d("User.name", "${employee.name}")
//            employee.name = "updated name"
//            employee.update {
//                Log.d("User.name", "${employee.name}")
//            }
//        }

        val employee = Employee()
        employee.salary = 4500

        employee.save {}

//        firestore.collection("employee").whereEqualTo("name", "Sanford").limit(1).limit(10)
//                .get().addOnCompleteListener { task ->
//                    print(task)
//                }


//        Employee.destroy("teste") { response ->
//            when(response) {
//                is Success -> response.result
//                is Failure -> TODO()
//            }
//        }

        Employee.where(Employee::age greaterThan 20).where(Employee::age lessThan 30).take { response ->
                    when(response) {
                        is Success -> response.result
                        is Failure -> TODO()
                    }
                }



//        val user = User()
//        user.name = "Jhon"
//        user.age = 19
//
//        user.destroy { print("this user was deleted on Firestore") }
//
//        user.update {
//            print("updated user um Firestore")
//        }
//
//        Employee.destroy("9qWVZ4Ar1dKnikGs5aAY") {
//            Log.d("result", "deleted")
//        }

//        val employee = Employee()
//        employee.salary = 2700
//        employee.name = "Sanford"

//        val user = User()
//        user.name = "Magic"
//        user.age = 24
//        user.birthDate = Date()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

open class User: FireRecord() {
    companion object: FireRecordCompanion<User>()

    var name: String? = null
    var age: Int? = null
    var birthDate: Date? = null
    @ServerTimestamp var createdAt: Date? = null
}

class Employee: User() {
    companion object: FireRecordCompanion<Employee>()

    var salary: Int? = null
    var image: FirebaseImage? = null
}
