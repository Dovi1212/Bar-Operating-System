package bar.os.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

import bar.os.controller.model.BottleTypeData;
import bar.os.dao.BottleTypeDao;
import bar.os.entity.BottleType;

public class BottleTypeService {

	@Autowired
	private BottleTypeDao bottleTypeDao;

	@Transactional(readOnly = false)
	public BottleTypeData addNewBottleType(BottleType bottleType) {
		Long bottleTypeId = bottleType.getBottleTypeId();
		BottleType dbBottleType = FindOrCreateBottleType(bottleTypeId, bottleType.getType());
		dbBottleType.setType(bottleType.getType());
		return new BottleTypeData(bottleTypeDao.save(dbBottleType));

	}

	private BottleType FindOrCreateBottleType(Long bottleTypeId, String type) {
		BottleType bottleType;
		if (Objects.isNull(bottleTypeId)) {
			Optional<BottleType> opType = bottleTypeDao.findByType(type);

			if (opType.isPresent()) {
				throw new DuplicateKeyException(type + " already exists in the system.");
			}
			bottleType = new BottleType();
		}

		else {
			bottleType = findBottleTypeById(bottleTypeId);
		}

		return bottleType;
	}

	private BottleType findBottleTypeById(Long bottleTypeId) {
		return bottleTypeDao.findById(bottleTypeId).orElseThrow(
				() -> new NoSuchElementException("Bottle type with ID=" + bottleTypeId + " does not exist"));
	}
	
	@Transactional(readOnly = true)
	public List<BottleTypeData> getAllBottleTypes() {
		List<BottleType> bottleTypes = bottleTypeDao.findAll();
		List<BottleTypeData> response = new LinkedList<>();
		
		for(BottleType bottletype : bottleTypes) {
			response.add(new BottleTypeData(bottletype));
		}		
		return response;
	}

}