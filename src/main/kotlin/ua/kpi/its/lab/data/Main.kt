package ua.kpi.its.lab.data

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import ua.kpi.its.lab.data.config.Config
import ua.kpi.its.lab.data.entity.Battery
import ua.kpi.its.lab.data.entity.Vehicle
import ua.kpi.its.lab.data.svc.VehicleService
import java.math.BigDecimal
import java.util.Calendar
fun main() {
    val context = AnnotationConfigApplicationContext(Config::class.java)
    val service = context.getBean(VehicleService::class.java)
    val calendar = context.getBean(Calendar::class.java)

    val battery1 = Battery(
        model = "Model 1",
        manufacturer = "1.0.1",
        manufactureDate = calendar.apply { set(2010, 0, 1, 0, 0, 0) }.time,
        type = "Asdasd",
        capacity = 7500,
        chargeTime = 740.0,
        isFastCharge = true
    )

    val vehicle1 = Vehicle(
        brand = "Brand 1",
        model = "Model 1",
        manufacturer = "1.0.1",
        manufactureDate = calendar.apply { set(2010, 0, 1, 0, 0, 0) }.time,
        maxSpeed = 150.0,
        price = BigDecimal("7500.00"),
        isABS = true,
        battery = battery1
    )
    val vehicle2 = Vehicle(
        brand = "Brand 2",
        model = "Model 2",
        manufacturer = "1.0.2",
        manufactureDate = calendar.apply { set(2010, 0, 1, 0, 0, 0) }.time,
        maxSpeed = 250.0,
        price = BigDecimal("8500.00"),
        isABS = true,
        battery = battery1
    )
    val vehicle3 = Vehicle(
        brand = "Brand 3",
        model = "Model 3",
        manufacturer = "1.0.3",
        manufactureDate = calendar.apply { set(2010, 0, 1, 0, 0, 0) }.time,
        maxSpeed = 350.0,
        price = BigDecimal("6500.00"),
        isABS = true,
        battery = battery1
    )
    val vehicle4 = Vehicle(
        brand = "Brand 4",
        model = "Model 4",
        manufacturer = "1.0.4",
        manufactureDate = calendar.apply { set(2010, 0, 1, 0, 0, 0) }.time,
        maxSpeed = 150.0,
        price = BigDecimal("3500.00"),
        isABS = true,
        battery = battery1
    )
    val vehicle5 = Vehicle(
        brand = "Brand 5",
        model = "Model 5",
        manufacturer = "1.0.5",
        manufactureDate = calendar.apply { set(2010, 0, 1, 0, 0, 0) }.time,
        maxSpeed = 550.0,
        price = BigDecimal("2500.00"),
        isABS = true,
        battery = battery1
    )

    service.create(vehicle1)
    service.create(vehicle2)
    service.create(vehicle3)
    service.create(vehicle4)
    service.create(vehicle5)


   // get instance with index = 3
    val vehicleSelected3 = service.readByIndex(3)
    println("Retrieved $vehicleSelected3")
    // remove instance with index = 4
    val vehicleDeleted4 = service.deleteByIndex(4)
    println("Removed $vehicleDeleted4")
}