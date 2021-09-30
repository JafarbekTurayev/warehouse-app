package warehouseapp.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouseapp.warehouse.entity.User;
import warehouseapp.warehouse.entity.Warehouse;
import warehouseapp.warehouse.payload.ApiResponse;
import warehouseapp.warehouse.payload.UserDto;
import warehouseapp.warehouse.repository.UserRepository;
import warehouseapp.warehouse.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    public ApiResponse save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        if (!userRepository.existsByPhoneNumber(userDto.getPhoneNumber())) return new ApiResponse("Phone Number is taken",false);
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setCode(userDto.getCode());
        List<Warehouse> warehousesById = warehouseRepository.findAllById(userDto.getWarehousesId());
        user.setWarehouses(warehousesById);
        userRepository.save(user);
        return new ApiResponse("Saved!",true);
    }

    public ApiResponse getOne(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(user -> new ApiResponse("Succeed", true, user)).orElseGet(() -> new ApiResponse("Not Found", false));
    }

    public ApiResponse edit(Integer id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) return  new ApiResponse("Not Found", false);
        User user = optionalUser.get();
        if (!userDto.getName().isEmpty()) user.setName(userDto.getName());
        if (!userDto.getLastName().isEmpty()) user.setLastName(userDto.getLastName());
        if (!userDto.getPassword().isEmpty()) user.setPassword(userDto.getPassword());
        if (!userDto.getPhoneNumber().isEmpty() && !userDto.getPhoneNumber().equals(user.getPhoneNumber())){
            if (!userRepository.existsByPhoneNumber(userDto.getPhoneNumber())) return new ApiResponse("Phone Number is taken",false);
            user.setPhoneNumber(userDto.getPhoneNumber());
        }
        if (!userDto.getCode().isEmpty()) user.setCode(userDto.getCode());
        if (!userDto.getWarehousesId().isEmpty()) {
            List<Warehouse> warehouseList = warehouseRepository.findAllById(userDto.getWarehousesId());
            user.setWarehouses(warehouseList);
        }
        return new ApiResponse("Edited!",true);
    }
}
