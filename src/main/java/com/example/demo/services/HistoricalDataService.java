package com.example.demo.services;


import com.example.demo.dtos.CropDto;
import com.example.demo.dtos.HistoricalDataDto;
import com.example.demo.dtos.WeatheralertDto;
import com.example.demo.entities.Crop;
import com.example.demo.entities.HistoricalData;
import com.example.demo.entities.Weatheralert;
import com.example.demo.interfaces.IHistoricalDataService;
import com.example.demo.repositories.CropRepository;
import com.example.demo.repositories.HistoricalDataRepository;
import com.example.demo.repositories.WeatherAlertRepository;
import com.example.demo.security.dtos.UserDto;
import com.example.demo.security.entities.User;
import com.example.demo.security.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HistoricalDataService implements IHistoricalDataService {
    @Autowired private HistoricalDataRepository historicalDataRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private CropRepository cropRepository;
    @Autowired private WeatherAlertRepository weatheralertRepository;

    @Override
    public HistoricalDataDto getHistoricalData(HistoricalDataDto dto) {

        HistoricalData entity = new HistoricalData();


        entity.sethDate(dto.gethDate());


        Long userId = dto.getUser().getId();
        if (userId == null) throw new RuntimeException("El userId es obligatorio");
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        entity.setUser(user);

        Long cropId = dto.getCrop().getId();
        if (cropId == null) throw new RuntimeException("El cropId es obligatorio");
        Crop crop = cropRepository.findById(cropId)
                .orElseThrow(() -> new RuntimeException("Cultivo no encontrado"));
        entity.setCrop(crop);

        Long waId = dto.getWeatheralert().getId();
        if (waId == null) throw new RuntimeException("El weatheralertId es obligatorio");
        Weatheralert wa = weatheralertRepository.findById(waId)
                .orElseThrow(() -> new RuntimeException("Alerta meteorológica no encontrada"));
        entity.setWeatheralert(wa);

        HistoricalData saved = historicalDataRepository.save(entity);

        HistoricalDataDto result = new HistoricalDataDto();
        result.setHistoricalDataId(saved.getHistoricalDataId());
        result.sethDate(saved.gethDate());

        UserDto ud = new UserDto();
        ud.setId(saved.getUser().getUserId());
        result.setUser(ud);

        CropDto cd = new CropDto();
        cd.setId(saved.getCrop().getId());
        result.setCrop(cd);

        WeatheralertDto wdto = new WeatheralertDto();
        wdto.setId(saved.getWeatheralert().getId());
        result.setWeatheralert(wdto);

        return result;
    }
}
