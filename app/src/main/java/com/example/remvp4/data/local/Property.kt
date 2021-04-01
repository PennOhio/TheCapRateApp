package com.example.remvp4.data.local

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize


@Entity(tableName = "property_table")
@VersionedParcelize
data class Property(
    @PrimaryKey(autoGenerate = false) val projectName: String,
    @ColumnInfo(name = "address") var address: String?,
    @ColumnInfo(name = "askingPrice") var askingPrice: Double?,
    @ColumnInfo(name = "renovationExpenses") var renovationExpenses: Double?,
    @ColumnInfo(name = "monthlyRent") var monthlyRent: Double?,
    @ColumnInfo(name = "expenseRatio") var expenseRatio: Double?,
    @ColumnInfo(name = "marketCapRate") var marketCapRate: Double?,
    @ColumnInfo(name = "noi") var noi: Double?,
    @ColumnInfo(name = "calculatedPropertyValue") var calculatedPropertyValue: Double?,
    @ColumnInfo(name = "purchasePrice") var purchasePrice: Double?,
    @ColumnInfo(name = "calculatedCapRate") var calculatedCapRate: Double?,
    @ColumnInfo(name = "cleaning") var cleaning: Double?,
    @ColumnInfo(name = "maintenance") var maintenance: Double?,
    @ColumnInfo(name = "leasing") var leasing: Double?,
    @ColumnInfo(name = "officeAndAdmin") var officeAndAdmin: Double?,
    @ColumnInfo(name = "managementFee") var managementFee: Double?,
    @ColumnInfo(name = "insurance") var insurance: Double?,
    @ColumnInfo(name = "nonCamUtilities") var nonCamUtilities: Double?,
    @ColumnInfo(name = "camUtilities") var camUtilities: Double?,
    @ColumnInfo(name = "replacementReserves") var replacementReserves: Double?,
    @ColumnInfo(name = "trash") var trash: Double?,
    @ColumnInfo(name= "realEstateTaxes") var realEstateTaxes: Double?,
    @ColumnInfo(name= "totalRecurringExpenses") var totalRecurringExpenses: Double?,
    @ColumnInfo(name= "kitchen") var kitchen: Double?,
    @ColumnInfo(name= "bathrooms") var bathrooms: Double?,
    @ColumnInfo(name= "paint") var paint: Double?,
    @ColumnInfo(name= "windows") var windows: Double?,
    @ColumnInfo(name= "flooring") var flooring: Double?,
    @ColumnInfo(name= "drywall") var drywall: Double?,
    @ColumnInfo(name= "plumbing") var plumbing: Double?,
    @ColumnInfo(name= "electric") var electric: Double?,
    @ColumnInfo(name= "doors") var doors: Double?,
    @ColumnInfo(name= "hvac") var hvac: Double?
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(projectName)
        parcel.writeString(address)
        parcel.writeValue(askingPrice)
        parcel.writeValue(renovationExpenses)
        parcel.writeValue(monthlyRent)
        parcel.writeValue(expenseRatio)
        parcel.writeValue(marketCapRate)
        parcel.writeValue(noi)
        parcel.writeValue(calculatedPropertyValue)
        parcel.writeValue(purchasePrice)
        parcel.writeValue(calculatedCapRate)
        parcel.writeValue(cleaning)
        parcel.writeValue(maintenance)
        parcel.writeValue(leasing)
        parcel.writeValue(officeAndAdmin)
        parcel.writeValue(managementFee)
        parcel.writeValue(insurance)
        parcel.writeValue(nonCamUtilities)
        parcel.writeValue(camUtilities)
        parcel.writeValue(replacementReserves)
        parcel.writeValue(trash)
        parcel.writeValue(realEstateTaxes)
        parcel.writeValue(totalRecurringExpenses)
        parcel.writeValue(kitchen)
        parcel.writeValue(bathrooms)
        parcel.writeValue(paint)
        parcel.writeValue(windows)
        parcel.writeValue(flooring)
        parcel.writeValue(drywall)
        parcel.writeValue(plumbing)
        parcel.writeValue(electric)
        parcel.writeValue(doors)
        parcel.writeValue(hvac)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Property> {
        override fun createFromParcel(parcel: Parcel): Property {
            return Property(parcel)
        }

        override fun newArray(size: Int): Array<Property?> {
            return arrayOfNulls(size)
        }
    }
}
