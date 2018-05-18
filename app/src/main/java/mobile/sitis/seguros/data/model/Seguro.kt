package mobile.sitis.seguros.data.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity
class Seguro(@PrimaryKey(autoGenerate = true) val id:Long?,
             val aseguradora:String,
             val beneficiario:String,
             val fecha: Date)