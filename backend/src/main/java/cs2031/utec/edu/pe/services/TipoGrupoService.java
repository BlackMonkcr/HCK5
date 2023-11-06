package cs2031.utec.edu.pe.services;
import cs2031.utec.edu.pe.repositories.TipoGrupoRepository;
import cs2031.utec.edu.pe.model.Grupo;
import cs2031.utec.edu.pe.model.TipoGrupo;
import cs2031.utec.edu.pe.services.GrupoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TipoGrupoService {

    @Autowired
    private TipoGrupoRepository tipoGrupoRepository;

    @Autowired
    private GrupoService groupService;

    public List<TipoGrupo> getAllTipos() {
        return tipoGrupoRepository.findAll();
    }

    public TipoGrupo getTipoById(Long id) {
        return tipoGrupoRepository.findById(id).orElse(null);
    }

    public TipoGrupo createTipoGrupo(TipoGrupo tipoGrupo) {
        return tipoGrupoRepository.save(tipoGrupo);
    }

    public List<Grupo> getTipoGrupo(Long id) {
        return tipoGrupoRepository.findById(id).orElse(null).getGrupos();
    }

    public TipoGrupo addGroupToTipo(Long id, Long groupId) {
        TipoGrupo tipoGrupo = tipoGrupoRepository.findById(id).orElse(null);
        if (tipoGrupo != null) {
            tipoGrupo.getGrupos().add(groupService.getGrupoById(groupId));
            return tipoGrupoRepository.save(tipoGrupo);
        } else {
            return null;
        }
    }
}