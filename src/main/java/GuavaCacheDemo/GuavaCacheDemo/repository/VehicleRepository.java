package GuavaCacheDemo.GuavaCacheDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import GuavaCacheDemo.GuavaCacheDemo.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
  Vehicle findByModelCode(String modelCode);
}
