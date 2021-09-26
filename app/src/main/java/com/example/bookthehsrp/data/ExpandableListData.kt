package com.example.bookthehsrp.data

internal object ExpandableListData{
    val data: HashMap<String, List<String>>
    get() {
        val expandableListDetail =
            HashMap<String, List<String>>()
        val vehicle_type: MutableList<String> =
            ArrayList()
        vehicle_type.add("4 wheeler")
        vehicle_type.add("3 wheeler")
        vehicle_type.add("2 wheeler")
        vehicle_type.add("Heavy duty")

        val fuel_type: MutableList<String> = ArrayList()
        fuel_type.add("Petrol")
        fuel_type.add("Diesel")
        fuel_type.add("Gasoline")
        fuel_type.add("cng")

        expandableListDetail["VEHICLE_TYPE"] = vehicle_type
        expandableListDetail["FUEL_TYPE"] = fuel_type

        return expandableListDetail
    }
}