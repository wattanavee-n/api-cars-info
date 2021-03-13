package th.ac.ku.carsinfo.controller;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.CarsInfo.model.CarsInfoEntity;
import th.ac.ku.CarsInfo.model.CarsInfoResponse;
import th.ac.ku.CarsInfo.repository.CarsInfoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cars-info")
public class CarsInfoController {

    private final CarsInfoRepository carsInfoRepository;

    public CarsInfoController(CarsInfoRepository carsInfoRepository) {
        this.carsInfoRepository = carsInfoRepository;
    }

    @GetMapping
    public List<CarsInfoEntity> findAll() {
        return this.carsInfoRepository.findAll();
    }

    @GetMapping("/{id}")
    public CarsInfoEntity findById(@PathVariable int id) {
        return this.carsInfoRepository.findById(id);
    }

    @PostMapping("/insert")
    public CarsInfoResponse insert(@RequestBody CarsInfoEntity carsInfoEntity) {
        CarsInfoResponse carsInfoResponse = new CarsInfoResponse();
        try {
            CarsInfoEntity carsInfo = this.carsInfoRepository.save(carsInfoEntity);
            carsInfoResponse.setMessage("Insert success");
            carsInfoResponse.setCarsInfo(carsInfo);
        } catch (Exception exception) {
            CarsInfoResponse.setMessage("Can not insert");
        }
        return carsInfoResponse;
    }

    @PutMapping("/update/{id}")
    public CarsInfoResponse update(@PathVariable int id,
                                           @RequestBody CarsInfoEntity carsInfoEntity) {
        CarsInfoResponse carsInfoResponse = new CarsInfoResponse();
        try {
            CarsInfoEntity carsInfo = this.CarsInfoRepository.findById(id);
            if (null != carsInfo) {
                carsInfo.setBrand(carsInfoEntity.getBrand());
                carsInfo.setdesc(carsInfoEntity.getdesc());
                carsInfo.setCarsType(carsInfoEntity.getCarsType());
                carsInfo.setSaleDate(carsInfoEntity.getSaleDate());
                carsInfo.setSaleTimes(carsInfoEntity.getSaleTimes());
                carsInfo = this.carsInfoRepository.save(carsInfo);
                carsInfo.setMessage("Update Success");
            } else {
                carsInfoResponse.setMessage("Everything all up to date");
            }
        } catch (Exception exception) {
            carsInfoResponse.setMessage("Can not update");
        }
        return carsInfoResponse;
    }

    @DeleteMapping("/delete/{id}")
    public CarsInfoResponse update(@PathVariable int id) {
        CarsInfoResponse carsInfoResponse = new CarsInfoResponse();
        try {
            CarsInfoEntity carsInfo = this.carsInfoRepository.findById(id);
            if (null != carsInfo) {
                this.carsInfoRepository.delete(carsInfo);
                carsInfoResponse.setMessage("Delete Success");
            } else {
                carsInfoResponse.setMessage("No data to delete");
            }
        } catch (Exception exception) {
            carsInfoResponse.setMessage("Can not Delete");
        }
        return carsInfoResponse;
    }
}
