package GuavaCacheDemo.GuavaCacheDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GuavaCacheDemo.GuavaCacheDemo.entity.Vehicle;
import GuavaCacheDemo.GuavaCacheDemo.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController  {

  @Autowired
  private VehicleService vehicleService;

  @PostMapping
  public ResponseEntity addVehicle(@RequestBody Vehicle vehicle) {
    String id = vehicleService.addVehicle(vehicle);
    return new ResponseEntity<String>(id, HttpStatus.OK);
  }

  @GetMapping("/{modelCode}")
  public ResponseEntity getVehicle(@PathVariable("modelCode") String modelCode) {
    Vehicle vehicle = vehicleService.getVehicle(modelCode);
    return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity updateVehicle(@RequestBody Vehicle vehicle) {
    Vehicle updatedVehicle = vehicleService.updateVehicle(vehicle);
    return new ResponseEntity<Vehicle>(updatedVehicle, HttpStatus.OK);
  }

  @DeleteMapping("/{modelCode}")
  public ResponseEntity addVehicle(@PathVariable("modelCode") String modelCode) {
    String id = vehicleService.deleteVehicle(modelCode);
    return new ResponseEntity<String>(id, HttpStatus.OK);
  }
}
