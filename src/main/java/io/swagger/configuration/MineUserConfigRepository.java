package io.swagger.configuration;

import io.swagger.model.MineUserConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MineUserConfigRepository extends CrudRepository<MineUserConfig, String> {

    MineUserConfig findByMineId(UUID mineId);

}