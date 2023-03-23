window.onload = () => {
    const upperMenu = document.getElementById("upperMenu")
    const btnUpperMenu = document.getElementById("btnUpperMenu")
    const btnPrevious = document.getElementById("btnPrevious")
    const btnNext = document.getElementById("btnNext")
    const property = document.getElementById("property")
    const value = document.getElementById("value")
    const copiedNotification = document.getElementById("copied")

    let items = []
    let index = 0

    let hasPdf = false
    toggleUpperMenuVisibility()

    const upperMenuButtons = [...upperMenu.children]
    upperMenuButtons.forEach((button) => {
        button.addEventListener('click', () => {
            hasPdf = true
            toggleUpperMenuVisibility()
        })
    })

    btnUpperMenu.addEventListener('click', () => toggleUpperMenuVisibility())
    btnPrevious.addEventListener('click', () => handleClick(-1))
    btnNext.addEventListener('click', () => handleClick(1))

    btnPrevious.style.display = "none"

    async function handleClick(offset) {
        if (!hasPdf) return

        index += offset
        if (index < 0 || index > items.length) return

        if (index === 0) btnPrevious.style.display = "none"
        else btnPrevious.style.display = "block"

        if (index === items.length - 1) btnNext.style.display = "none"
        else btnNext.style.display = "block"

        const { property: iProperty, value: iValue } = items[index]
        property.innerText = iProperty
        value.innerText = iValue

        try {
            await navigator.clipboard.writeText(value)
            copiedNotification.style.opacity = 1
            setTimeout(() => {
                copiedNotification.style.opacity = 0
            }, 600);
        } catch (e) {
            console.log(e)
        }
    }

    window.addEventListener('focus', () => {
        if (!hasPdf) return

        if (index === items.length - 1) index = -1
        handleClick(1)
    })

    function toggleUpperMenuVisibility() {
        if (!upperMenu.style.top || upperMenu.style.top === '-280px') {
            upperMenu.style.top = '0px'
            btnUpperMenu.style.display = "none"
            items = [
                { property: "Modelo", value: "Valor Modelo" },
                { property: "Descrição Renavam", value: "Valor Descrição Renavam" },
                { property: "Descrição", value: "Valor Descrição" },
                { property: "Sigla", value: "Valor Sigla" },
                { property: "Versão", value: "Valor Versão" },
                { property: "Ano", value: "Valor Ano" },
                { property: "Linha", value: "Valor Linha" },
                { property: "Carroçaria", value: "Valor Carroçaria" },
                { property: "Segmento", value: "Valor Segmento" },
                { property: "Motor", value: "Valor Motor" },
                { property: "Cilindradas", value: "Valor Cilindradas" },
                { property: "Nro Cilindros", value: "Valor Nro Cilindros" },
                { property: "Potencia", value: "Valor Potencia" },
                { property: "Frete especifico", value: "Valor Frete especifico" },
                { property: "Valor", value: "Valor Valor" },
                { property: "Potência 1", value: "Valor Potência 1" },
                { property: "Carga", value: "Valor Carga" },
                { property: "Num Passageiros", value: "Valor Num Passageiros" },
                { property: "Num Portas", value: "Valor Num Portas" },
                { property: "Num Renavam", value: "Valor Num Renavam" },
                { property: "Espécie", value: "Valor Espécie" },
                { property: "Prazo Garantia", value: "Valor Prazo Garantia" },
                { property: "Km Garantia", value: "Valor Km Garantia" },
                { property: "Observacao", value: "Valor Observacao" }
            ]
            value.style.display = "none"
            btnPrevious.style.display = "none"
            btnNext.style.display = "none"
            index = 0
        } else {
            upperMenu.style.top = '-280px'
            btnUpperMenu.style.display = "block"
            btnPrevious.style.display = "block"
            btnNext.style.display = "block"
            value.style.display = "block"
            property.innerText = items[0].property
            value.innerText = items[0].value
        }
    }
}
